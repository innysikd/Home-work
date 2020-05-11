/* const addButton = document.getElementById("add-btn");
let addButton1 = document.querySelector("#add-btn"); // another way to find an element, through css

function onClickAddButton (event){
    alert("Button clicked");
    event.preventDefault(); // we cancel any custom behaviour
    const thisButton = event.currentTarget;
    if (thisButton.classList.contains("blue")){
        thisButton.classList.remove("blue");
        thisButton.classList.add("red")
    }else{
        thisButton.classList.add("blue");
        thisButton.classList.remove("red");
    }
}

//addButton.addEventListener("click", onClickAddButton);

addButton.href; // standard attributes are becoming a field of the DOM tree. to get to the standard attribute inside add-btn

addButton.property = "another property"; // we can assign different properties to the objects

addButton.getAttribute("another property"); // to get to the custom attribute

*/

// our project
const NEW_CONTACT_PATH = "/contact";

// js starts working only after all the elements were downloaded into the DOM
// like main method in java
document.addEventListener("DOMContentLoaded", contacs);

function contactsOld(){
    const addFormDom = document.getElementById("add-contact-form");
    addFormDom.addEventListener("submit", addContact);

    function addContact(event) {
        event.preventDefault();
        const formData = new FormData(addFormDom); // to send the form to the server
        addFormDom.addEventListener("submit", addContact);

        fetch("/contact",
            {
                method: 'POST',
                body: formData,
            }
            ).then(value => {
                console.log(value.json());
        }
        ).catch(error => console.log(error));
    }
}




