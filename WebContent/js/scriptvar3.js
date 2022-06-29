function formReset(){
	let id = document.getElementById('id');
	let name = document.getElementById('name');
	let password = document.getElementById('password');
	let role = document.getElementById('role');



	id.value = '';
	name.value = '';
	password.value = '';
	role.value = '';


}
function updateValue(){
	const idHidden = document.getElementById('idHidden');
	const id = document.getElementById('id');
	idHidden.value = id.value;
}