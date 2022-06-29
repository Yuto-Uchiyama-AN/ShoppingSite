
function formReset(){
	let id = document.getElementById('id');
	let name = document.getElementById('name');
	let price = document.getElementById('price');
	let info = document.getElementById('info');
	let imgname = document.getElementById('imgname');


	id.value = '';
	name.value = '';
	price.value = '';
	info.value = '';
	imgname.value = '';

}
/** memberIdのvalueを取得し、memberIdHiddenのvalueに格納する */
function updateValue(){
	const idHidden = document.getElementById('idHidden');
	const id = document.getElementById('id');
	idHidden.value = id.value;
}