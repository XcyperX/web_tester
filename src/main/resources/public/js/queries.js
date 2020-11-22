submitNewUser = () => {
    let createUser = document.forms.createUser;
    for (let i in createUser.elements) {
        let field = createUser.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof user[field.id] === 'number') {
                user[field.id] = Number(field.value);
            } else {
                user[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(user);
    createNewUser(user);
}

submitNewGroup = () => {
    let createGroup = document.forms.createGroup;
    for (let i in createGroup.elements) {
        let field = createGroup.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof group[field.id] === 'number') {
                group[field.id] = Number(field.value);
            } else {
                group[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(group);
    createNewGroup(group);
}

submitNewStudent = () => {
    let createStudent = document.forms.createStudent;
    for (let i in createStudent.elements) {
        let field = createStudent.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof student[field.id] === 'number') {
                student[field.id] = Number(field.value);
            } else {
                student[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(student);
    createNewStudent(student);
}

submitNewTest = () => {
    let createTest = document.forms.createTest;
    for (let i in createTest.elements) {
        let field = createTest.elements[i];
        if (field.type === 'text' || field.type === 'select-one') {
            if (typeof test[field.id] === 'number') {
                test[field.id] = Number(field.value);
            } else {
                test[field.id] = field.value;
            }
        } else if (field.type === 'file') {
            obj['note'] = field.files[0];
        }
    }
    console.log(test);
    createNewTest(test);
}

const user = {
    teacher_id: -1,
    email: "",
    name: "",
    surname: "",
    password: "",
    role: ""
}

const group = {
    id: -1,
    name: "",
    teacher_id: 1
}

const student = {
    student_id: -1,
    name: "",
    surname: "",
    group_id: -1
}

const test = {
    id: -1,
    name: "",
    teacher_id: 1
}

createNewUser = (user) => {
    sendRequest('POST', '/api/registrations', user).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

createNewGroup = (group) => {
    sendRequest('POST', '/api/groups', group).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

createNewTest = (test) => {
    sendRequest('POST', '/api/tests', test).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

createNewStudent = (student) => {
    sendRequest('POST', '/api/students', student).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}
//updatesUser = (user) => {
//    console.log(user);
//    sendRequest('PUT', '/api/users/' + user.user_id, user).then(response => {
//        if (response.ok) {
//            console.log(response);
//            document.location.href = "http://localhost:8080/users";
//        } else {
//            console.log(response);
//        }
//    });
//}
//
//updatesProduct = (product) => {
//    console.log(user);
//    sendRequest('PUT', '/api/products/items/' + product.product_id, product).then(response => {
//        if (response.ok) {
//            console.log(response);
//            document.location.href = "http://localhost:8080/products";
//        } else {
//            console.log(response);
//        }
//    });
//}
//
//updateSupplier = (productId) => {
//    console.log(productId);
//    let supplier = document.getElementById("ordered_supplier_" + productId);
//    const amountSupplier = {
//        amount: supplier.value
//    }
//    console.log(user);
//    sendRequest('PUT', '/api/supplier/items/' + productId, amountSupplier).then(response => {
//        if (response.ok) {
//            console.log(response);
//            document.location.href = "http://localhost:8080/products";
//        } else {
//            console.log(response);
//        }
//    });
//}
//
//deleteUser = (userId) => {
//    console.log(user);
//    sendRequest('DELETE', '/api/users/' + userId).then(response => {
//        if (response.ok) {
//            console.log(response);
//            document.location.href = "http://localhost:8080/users";
//        } else {
//            console.log(response);
//        }
//    });
//}

sendRequest = (method, url, body) => {
    const headers = {
        'Content-Type': 'application/json'
    }
    console.log(body);
    if (body !== null) {
        return fetch(url, {
            method: method,
            body: JSON.stringify(body),
            headers: headers
        });
    } else {
        return fetch(url, {
            method: method,
            headers: headers
        });
    }
}

function addAnswers() {
	if (x < 10) {
    var str = '<div class="form-check">' +
                '<input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">' +
                '<input id="name" type="text" name="groupName" class="form-control" placeholder="Введите текст вопроса">' +
               '</div>';
    document.innerHTML = str;
    x++;
  } else
  {
  	alert('STOP it!');
  }
}