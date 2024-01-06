window.addEventListener('load', ()=>{
    document.querySelector('.next').addEventListener('click', ()=> nextSlile());
    document.querySelector('.pre').addEventListener('click', ()=> preSlide())
     //phần hiển thị biểu mẫu
     document.querySelector('#bieu-mau').addEventListener('click', ()=>showBieuMau());//hiện
     document.querySelector('#icon-close').addEventListener('click', ()=>closeBieuMau());//ẩn
    
})
const showBieuMau = ()=>{
    document.querySelector('.popup-bieu-mau').classList.remove('close-popup');
}
const closeBieuMau = ()=>{
    document.querySelector('.popup-bieu-mau').classList.add('close-popup');
}
const nextSlile = ()=>{
    const listItems = document.querySelectorAll('.item');
    document.querySelector('#slide').appendChild(listItems[0]);
    console.log(listItems);
}
const preSlide = ()=>{
    const listItems = document.querySelectorAll('.item');
    document.querySelector('#slide').prepend(listItems[listItems.length -1]);
    console.log(listItems);
}