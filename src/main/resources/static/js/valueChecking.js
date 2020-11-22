
var firstName = document.getElementById("firstName");
var lastName = document.getElementById("lastName");
var age = document.getElementById("age");
var save = document.getElementById("save");
var form = document.getElementById("form");
 class valueChecking {


     valueChecked(e) {
         e.preventDefault();

         if (firstName.value== "" ) {

             alert("First Name is Required");
         }
         else if(lastName.value== "") {
             alert("last Name is Required");
         }
         else if(age.value== ""){
             alert("age is Required");
         }
         else{
             //para irun ang button maexecute
             document.getElementById("form").submit();
         }

     }


     Run() {
         save.onclick= this.valueChecked

     }

 }

var checking = new valueChecking();
checking.Run()
