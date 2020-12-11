$(document).ready(function(){

    $("#myModal").modal({
        keyboard: true,
        backdrop: "static",
        show: false,

    }).on("show.bs.modal", function(event){
        var button = $(event.relatedTarget); // button the triggered modal
        var personId = button.data("id");

        //data-id of button which is equal to id (primary key) of person
        /*
        Although below is working to get and display values for id (personId),
        it is recommended that they be fetched via ajax ($.ajax()) that queries data
        from database based on personId
        */



        const id = 1;
        editTodo($(this), personId);

        // $("#inputId").val(personId);
        $("#firstNameUpdate").val();
        $("#lastNameUpdate").val();
        $("#ageUpdate").val();
        console.log(todo);

        //displays values to modal
        $(this).find("#personDetails").html($("<b>ID: " + personId + "<br>Last Name: " + lastName + "<br>First Name: " + firstName + "</b>"))
    }).on("hide.bs.modal", function (event) {
        $(this).find("#personDetails").html("");
    });

}); //body end
//todo equal to pojo
async function editTodo(modal, id) {
    const personResponse = await personService.findById(id);
    const personJson = personResponse.json();

    personJson.then(person => {
        // personJson is equal to POJO
        modal.find("#inputId").val(person.id);
        modal.find("#firstNameUpdate").val(person.firstName);
        modal.find("#lastNameUpdate").val(person.lastName);
        modal.find("#ageUpdate").val(person.age);
        console.log(todo);
    });
}

const http = {
    fetch: async function(url, options = {}) {
        const response = await fetch(url, {
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            ...options,
        });

        return response;
    }
};
const personService = {
    findById: async (id) => {
        return await http.fetch('/api/persons/' + id);
    },
};