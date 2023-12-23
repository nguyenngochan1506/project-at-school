

window.addEventListener('load', ()=>{
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