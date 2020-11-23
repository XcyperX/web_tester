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
    let tempQuestion = {...question};
    let tempTest = {...test};
    tempTest.questions = [];
    tempTest["name"] = document.getElementById("nameTest").value;
    tempTest["owner_id"] = document.getElementById("id_owner").getAttribute("value");
    let questions = document.getElementsByClassName("question");
    for (let i = 0; i < questions.length; ++i) {
        tempQuestion.answers = [];
        tempQuestion["text"] = questions[i].getElementsByClassName("textQuestion")[0].value;
        let answers = questions[i].getElementsByClassName("answer");
        for (let j = 0; j < answers.length; ++j) {
            answer["text"] = answers[j].getElementsByClassName("textAnswer")[0].value;
            answer["is_correct"] = answers[j].getElementsByClassName("defaultCheck")[0].getAttribute("value");
            tempQuestion.answers.push(JSON.parse(JSON.stringify(answer)));
        }
        let questionJson = JSON.stringify(tempQuestion);
        tempTest["questions"].push(JSON.parse(questionJson));
    }
    console.log(tempTest);
    createNewTest(tempTest);
}

const answer = {
    id: -1,
    text: "",
    is_correct: false
}

const question = {
    id: -1,
    text: "",
    answers: []
}

const test = {
    id: -1,
    name: "",
    owner_id: -1,
    questions: []
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
    teacher_id: 2
}

const student = {
    student_id: -1,
    name: "",
    surname: "",
    group_id: -1
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
    var str = `<div class="form-check mb-2 answer">
                    <input class="form-check-input defaultCheck" type="checkbox" value="false" id="checkbox_check"
                           onclick="testCheck(this)">
                    <input id="textAnswer" type="text" name="textAnswer" class="form-control textAnswer"
                           placeholder="Введите ответ">
                </div>`;
    let answer = document.createRange().createContextualFragment(str);
    var questions = document.getElementsByClassName("question");
    var lastQuestion = questions[questions.length - 1].getElementsByClassName("answers");
    lastQuestion[0].appendChild(answer);
}

function addQuestions() {
    var str = `<div class="question">
                <div class="form-row">
                    <div class="form-group">
                        <label>Введите вопрос</label>
                        <input id="textQuestion" type="text" name="textQuestion" class="form-control textQuestion"
                               placeholder="Введите текст вопроса">
                    </div>
                </div>
                <div class="container">
                    <div class="answers">
                        <div class="form-check mb-2 answer">
                            <input class="form-check-input defaultCheck" type="checkbox" value="false" id="checkbox_check"
                                   onclick="testCheck(this)">
                            <input id="textAnswer" type="text" name="textAnswer" class="form-control textAnswer"
                                   placeholder="Введите ответ">
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <input class="btn btn-primary mb-4" type="button" onclick="addAnswers()" value="Добавить ответ">
                    </div>
                </div>
            </div>`;
    let question = document.createRange().createContextualFragment(str);
    var questions = document.getElementsByClassName("question");
    questions[questions.length - 1].getElementsByClassName("btn")[0].remove();
    document.getElementsByClassName("questions")[0].appendChild(question);
}

function testCheck(elem) {
    if (elem.checked) {
        elem.setAttribute("value", "true");
    } else {
        elem.setAttribute("value", "false");
    }
}
