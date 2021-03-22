const check = document.querySelector('#checkNav');
const main = document.querySelector('.main');
let checkState = false; 
check.addEventListener('click',()=>{
    if(checkState){
        main.style.width = '100%';
        checkState = false;
    }else{
        main.style.width = '70%';
        checkState = true;
    }
})

// let btnBack = document.querySelectorAll('#back');
// let btnNext = document.querySelectorAll('#next');
let checkBtnarr = document.querySelectorAll('.checkBtn');
let checkArr = document.querySelectorAll('.radio');
let chkArr = document.querySelectorAll('.checkpr');
// const sanpham = document.querySelector('#sanpham'); 
const select = document.querySelector(".sanpham img");
let arrayImg1 = ["hinh1.png", "hinh50.png", "anh100.png"];
let arrayImg2 = ["anh2.png", "anh250.png", "anh2full.png"];
let arrayImg3 = ["img1.png", "img2.png", "img3.png"];
let arrayImg4 = ["sec1.png", "sec2.png", "sec3.png"];
let arrayImg5 = ["zec1.png", "zec2.png", "zec3.png"];
let arrayImg6 = ["bc1.png", "bc2.png", "bc3.png"];

// Chuyển hình slutter
document.querySelector('#product').src = "./public/images" + arrayImg3[0];
slideImg(arrayImg3);
checkArr.forEach(item =>{
    item.addEventListener('click', ()=>{
        if(item.value == "1"){
            document.querySelector('#product').src = "./public/images/" + arrayImg3[0];
            slideImg(arrayImg3);
        }
        if(item.value == "2"){
            document.querySelector('#product').src = "./public/images/" + arrayImg4[0];
            slideImg(arrayImg4);
        }
        if(item.value == "3"){
            document.querySelector('#product').src = "./public/images/" + arrayImg5[0];
            slideImg(arrayImg5);
        }
    });
})

// Chuyển product trang 1
document.querySelector('#product').src = "./public/images/" + arrayImg1[0];
slideImg(arrayImg1);    
checkBtnarr.forEach(item => {
    item.addEventListener('click', ()=> {
        if (item.value == "checkBtn1") {
            document.querySelector('#product').src = "./public/images/" + arrayImg1[0];
            slideImg(arrayImg1);
        }
        if (item.value == "checkBtn2"){
            document.querySelector('#product').src = "./public/images/" + arrayImg6[0];
            slideImg(arrayImg6);
        }
    });
})

// Chuyển trang system
document.querySelectorAll('#product').src = "./public/images" + arrayImg1[0];
slideImg(arrayImg1);
chkArr.forEach(item =>{
    item.addEventListener('click', ()=>{
        if(item.value == "val1"){
            document.querySelector('#product').src = "./public/images/" + arrayImg1[0]
            slideImg(arrayImg1);
        }
        if(item.value == "val2"){
            document.querySelector('#product').src = "./public/images/" + arrayImg6[0]
            slideImg(arrayImg6);
        }
    })
}) 

function slideImg(arrImg) {
    let dem = 0;
    select.onclick = () => {
        dem++;
        document.querySelector('#product').src = "./public/images/" + arrImg[dem];
        if (dem == 3) {
            dem = 0;
            document.querySelector('#product').src = "./public/images/" + arrImg[dem];
        }
    }
}
