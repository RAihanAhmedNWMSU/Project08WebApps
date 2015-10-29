/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function getResult(){
    var allDataEntered=true;
    request=new XMLHttpRequest();
    if(document.getElementById("flavor").value === "none"){
        allDataEntered=false;
        alert("Flavor Not Entered");
    }
    if(!(document.getElementById("small").checked) && !(document.getElementById("medium").checked) && !(document.getElementById("large").checked)){
        allDataEntered=false;
     alert("Size Not Selected");   
    }
    if((document.getElementById("quantity").value === "none") || (document.getElementById("quantity").value <= 0) || (document.getElementById("quantity").value) > 10 ){
        allDataEntered=false;
        alert("Quantity Not Entered");
    }
    if(allDataEntered){
    var sizeCheck;
    if(document.getElementById("small").checked)
        sizeCheck=document.getElementById("small").value;
    else if(document.getElementById("medium").checked)
        sizeCheck=document.getElementById("medium").value;
    else if(document.getElementById("large").checked)
        sizeCheck=document.getElementById("large").value;
    var toppingsInUrl="";
    if(document.getElementById("saltedcaramel").checked){
        toppingsInUrl=toppingsInUrl+"&topping="+document.getElementById("saltedcaramel").value;
    }
    if(document.getElementById("sugarfreestrawberry").checked){
       toppingsInUrl=toppingsInUrl+"&topping1="+document.getElementById("sugarfreestrawberry").value;
    }
    var url= "MohammedRAihan?flavor="+document.getElementById("flavor").value+"&size="+sizeCheck+"&quantity="+document.getElementById("quantity").value+toppingsInUrl;
    request.open("GET",url,true);
    request.onreadystatechange=getFinalResult;
    request.send(null);
    }
    
}

function getFinalResult(){
    if (request.readyState === 4 && request.status === 200) {
      document.getElementById("result").innerHTML = request.responseText;
   }
}

window.onload = function() {
   document.getElementById("order").onclick = getResult;
};
