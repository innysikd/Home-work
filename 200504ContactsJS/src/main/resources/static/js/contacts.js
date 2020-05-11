// js starts working only after all the elements were downloaded into the DOM
// like the main() method in Java
document.addEventListener("DOMContentLoaded", function main() {
    const contactFormDom = document.getElementById("contact-form"); // dom element of the contact form
    const contactWrapperDom = document.getElementById("contact-wrapper"); // dom element of the wrapper of all the contacts. it listens to clicks

    const contactService = new ContactService(contactWrapperDom, contactFormDom);
    const contactFormListener = new ContactFormListener(contactService);
    const contactWrapperListener = new ContactWrapperListener(contactService);

    // the listener is always there. no matter that we render all the elements (contacts). this way we don't have to assign a listener to each contact
    contactFormDom.addEventListener("click", contactFormListener);
    contactWrapperDom.addEventListener("click", contactWrapperListener);
});

//like a controller in Java
class ContactFormListener{

    constructor(contactService) {
        this.contactService = contactService;
    }

    handleEvent(event){
        // dataset - is where are custom attributes are saved. we always call them data-smth
        // target = what was clicked, DOM element. action = the name of a non-standard attribute with prefix "data".
        const action = event.target.dataset.action; // a link to the element where the event happened
        if(action === undefined) // if we clicked somewhere else and not on the target with attribute "action" (add. edit. cancel)
            return;
        this[action](event); // if action has "add". same as this.add. means this["add"](event);
    }

    addContact(event){
        event.preventDefault();
        const contactFormDom = event.currentTarget; // currentTarget = always contactWrapper
        const contact = {
            name: contactFormDom.elements.name.value,
            lastName: contactFormDom.elements.lastName.value,
            age: contactFormDom.elements.age.value,
        }

        this.contactService.addContact(contact);
    }

    editContact(event){
        event.preventDefault();

        const contactFormDom = event.currentTarget;
        const contact = {
            id: contactFormDom.elements.id.value,
            name: contactFormDom.elements.name.value,
            lastName: contactFormDom.elements.lastName.value,
            age: contactFormDom.elements.age.value,
        }

        this.contactService.editContact(contact);
    }

    // when cancel is clicked we come to the add page
    cancelEditing(event){
        event.preventDefault();
        this.contactService.switchToAddForm();
    }
}

// where the contacts from the server are
class ContactWrapperListener{
    constructor(contactService){
        this.contactService = contactService;
    }

    handleEvent(event){
        const action = event.target.dataset.action;
        if(action !== undefined)
        this[action](event);
    }

    removeContact(event){
        event.preventDefault();
        const contactDom = event.target.closest("li.collection-item"); // target = click, where the event happened. li... = closest parent
        const contactId = contactDom.contact.id;
        this.contactService.removeById(contactId);
    }

    editContact(event){
        event.preventDefault();
        const contactDom = event.target.closest("li.collection-item");
        this.contactService.switchToEditForm(contactDom.contact);
    }

    toggleContact(event){ // contactDom starts with li
        event.preventDefault();
        const contactDom = event.target.closest("li.collection-item");
        this.contactService.toggleContactDom(contactDom);
    }
}

//like a Service class in Java
class ContactService{
    constructor(contactWrapperDom, contactFormDom) {
        this.contactWrapperDom = contactWrapperDom;
        this.contactFormDom = contactFormDom;

        this.addButtonDom = contactFormDom.querySelector('[data-action="addContact]');
        this.editButtonDom = contactFormDom.querySelector('[data-action="editContact]');
        this.cancelButtonDom = contactFormDom.querySelector('[data-action="cancelEditing]');
        this._reInit();
    }

    //sends data of the new contact to the server and updates the list of contacts (without reloading the page)
    async addContact(contact) {
        const response = await fetch("/contact", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact),
        })

        if (response.ok) {
            this._reInit();
            this.clearForm();
        }
    }

    //sends data of an existing contact to the server and updates the list of contacts
    async editContact(contact) {
        const response = await fetch("/contact", {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(contact)
        })

        if (response.ok) {
            this._reInit();
            this.switchToAddForm();
        }
    }

    cancel(event){
        event.preventDefault();
        this.contactService.switchToAddForm();
    }

    //sends a request to the server to remove the contact and updates the list of contacts
    async removeById(id) {
        const response = await fetch(`/contact/${id}`, {
            method: 'DELETE',
        })

        if (response.ok) {
            this._reInit();
        }
    }

    switchToEditForm(contact){
        this.contactFormDom.elements.id.value = contact.id;
        this.contactFormDom.elements.name.value = contact.name;
        this.contactFormDom.elements.lastName.value = contact.lastName;
        this.contactFormDom.elements.age.value = contact.age;

        // after editing the add button should disappear and the others - appear
        this.addButtonDom.style.display = " ";
        this.editButtonDom.style.display = "block";
        this.cancelButtonDom.style.display = "block";
    }

    switchToAddForm(){
        this.clearForm();

        this.addButtonDom.style.display = "block";
        this.editButtonDom.style.display = "none";
        this.cancelButtonDom.style.display = "none";
    }

    clearForm(){
        this.contactFormDom.elements.id.value = "";
        this.contactFormDom.elements.name.value = "";
        this.contactFormDom.elements.lastName.value = "";
        this.contactFormDom.elements.age.value = "";
    }

    toggleContactDom(contactDom){ // contactDom = the whole contact starts with li incl contact and whats is inside it
        const contactDataDom = contactDom.querySelector(".contact-data");// we are looking for this element and we hide or show it
        contactDataDom.classList.toggle("hide"); // "hide" is a class from css of materialize. toggle - a method of this "hide" class

    }

    // _means, that this function is private
    // downloading new contacts from service and render: with html code put it into our page
    async _reInit(){
        const contacts = await this._downloadContacts();
        this._renderContacts(contacts);
    }

    async _downloadContacts(){
        const response = await fetch ("/contact");
        return response.json();
    }

    _renderContacts(contacts){ // html code for one contact
        this.contactWrapperDom.innerHTML = "";
        const collectionHeader = document.createElement("li");
        collectionHeader.className = "collection-header";
        collectionHeader.innerHTML = "<h4>Contacts</h4>";

        this.contactWrapperDom.append(collectionHeader);

        for (let contact of contacts){
            const contactDom = this._renderContact(contact);
            this.contactWrapperDom.append(contactDom);
        }
    }

    _renderContact(contact){
        const contactDom = document.createElement("li"); // we look for "collection-item" and then go to "li" element
        contactDom.className = "collection-item";
        contactDom.contact = contact; // in this DOM element we saved information about our contact
        contactDom.innerHTML =
            `<div>
                    <a href "/contact/${contact.id}">
                        <span data-action="toggleContact">${contact.name} ${contact.lastName}</span>
                    </a>
                <span class="secondary-content">
                    <a href ="">
                        <i data-action="editContact" class="material-icons teal-text text-darken-1">create</i></a>
                    <a href ="">
                        <i data-action="removeContact" class="material-icons deep-orange-text text-darken-1">delete</i></a>
                </span>
                
                ${this._renderContactData(contact)} <!--was put outside for more convenience -->
            </div>`;

        return contactDom;
    }

    // to hide and show contact details on click inside the html
    _renderContactData(contact){
        return `<ul class="collection contact-data hide">
                    <li class="collection-item">
                        <div>Name<span class="secondary-content blue-text text-darken-1" >${contact.name}</span>
                        </div>
                    </li>
                    <li class="collection-item">
                        <div>Last Name<span class="secondary-content blue-text text-darken-1">${contact.lastName}</span>
                        </div>
                    </li>
                    <li class="collection-item">
                        <div>Age<span class="secondary-content blue-text text-darken-1">${contact.age}</span>
                        </div>
                    </li>
                </ul>`
    }

}




