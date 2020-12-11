$(document).ready(function(){

    $("#myModal2").modal({
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
        deleteTodo($(this), personId);

        $("#deleteId").val(personId);


        //displays values to modal
        $(this).find("#personDetails").html($("<b>ID: " + personId))
    }).on("hide.bs.modal", function (event) {
        $(this).find("#personDetails").html("");
    });

}); //body end
//todo equal to pojo
async function deleteTodo(modal, id) {
    const personResponse = await personId.findById(id);
    const personJson = personResponse.json();

    personJson.then(person => {
        // personJson is equal to POJO
        modal.find("#deleteId").val(person.id);
        console.log(todo);
    });
}
//cons meaning static wala dpt kapareho to cons myId ay pangalan ng function mo
const myId = {
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
const personId = {
    findById: async (id) => {
        return await myId.fetch('/api/persons/' + id);
    },
};