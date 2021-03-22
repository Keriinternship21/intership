let checkBtnarr = document.querySelectorAll('.checkBtn');
const sanpham = document.querySelector('#sanpham');
const select = document.querySelector(".sanpham img");
let arrayImg1 = ["hinh1.png", "hinh50.png", "anh100.png"];
let arrayImg2 = ["anh2.png", "anh250.png", "anh2full.png"];
let dem = 0;

select.onclick = () => {
    dem++;
    if (dem == 3) {
        dem = 0;
    }
}
document.querySelector('#product').src = "./public/img/" + arrayImg1[dem];
slideImg(arrayImg1);
checkBtnarr.forEach(item => {

    item.addEventListener('click', () => {
        if (item.value == "checkBtn1") {
            document.querySelector('#product').src = "./public/img/" + arrayImg1[dem];
           
            slideImg(arrayImg1);
        }
        if (item.value == "checkBtn2"){
            document.querySelector('#product').src = "./public/img/" + arrayImg2[dem];
           
            slideImg(arrayImg2);
        }
    });
})

function slideImg(arrImg) {
    select.onclick = () => {
        dem++;
        document.querySelector('#product').src = "./public/img/" + arrImg[dem];
        if (dem == 3) {
            dem = 0;
            document.querySelector('#product').src = "./public/img/" + arrImg[dem];
        }
    }
}

/*thay doi items menu 3*/
let selectedElement = document.querySelectorAll(".btn-click");
let selectMenu = document.getElementById("#visible");
selectedElement.forEach(item => {
    item.onclick = () => {
        selectedElement.forEach(item1 => {
            item1.classList.remove('selected');
        })
        item.classList.add("selected");
    }
})
    
$('.btnClickShow').each(function(index){
    $(this).click(function(){
        if(index===0){
            document.querySelector('#concealed').style.display = 'none';
            document.querySelector('#visible').style.display = 'block';
        }
        else{
            document.querySelector('#concealed').style.display = 'block';
            document.querySelector('#visible').style.display = 'none';
        }   
    })
})

