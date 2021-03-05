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

submitNewTestResult = () => {
    let tempQuestionToAnswer = {...questionToAnswer};
    testResultJson.result = [];
    testResultJson.test_id = testResult.test_id;
    testResultJson.student_id = Number(document.getElementById("student_id").value);
    let questions = document.getElementsByClassName("question");
    for (let i = 0; i < questions.length; ++i) {
        tempQuestionToAnswer.question_id = Number(questions[i].getAttribute("id"));
        let answers = questions[i].getElementsByClassName("answer");
        for (let j = 0; j < answers.length; ++j) {
            console.log(answers[j].getElementsByClassName("defaultCheck")[0].getAttribute("value"));
            if (answers[j].getElementsByClassName("defaultCheck")[0].getAttribute("value") === "true") {
                tempQuestionToAnswer.answer_id = Number(answers[j].getElementsByTagName("label")[0].getAttribute("id"));
            }
        }
        testResultJson.result.push(JSON.parse(JSON.stringify(tempQuestionToAnswer)));
    }
    console.log(testResultJson);
    createNewStudentResult(testResultJson);
}

submitUpdateStudent = (student_id) => {
    let legacyStudent = document.getElementById("updateStudent_" + student_id);
    student.name = legacyStudent.querySelector("#name").value;
    student.surname = legacyStudent.querySelector("#surname").value;
    student.group_id = legacyStudent.querySelector("#group_id").value;
    student.student_id = student_id;
    console.log(student);
    updateStudent(student, student_id);
}

submitUpdateTeacher = (teacher_id) => {
    let legacyTeacher = document.getElementById("updateTeacher_" + teacher_id);
    user.teacher_id = teacher_id;
    user.email = legacyTeacher.querySelector("#email").value;
    user.name = legacyTeacher.querySelector("#name").value;
    user.surname = legacyTeacher.querySelector("#surname").value;
    user.surname = legacyTeacher.querySelector("#second_name").value;
    user.password = legacyTeacher.querySelector("#password").value;
    user.role = legacyTeacher.querySelector("#role").value;

    console.log(user);
    updateTeacher(user, teacher_id);
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
    second_name: "",
    password: "",
    role: ""
}

const group = {
    id: -1,
    name: "",
    teacher_id: -1
}

const student = {
    student_id: -1,
    name: "",
    surname: "",
    group_id: -1
}

const testResultJson = {
    id: -1,
    test_id: -1,
    student_id: -1,
    result: []
}

const questionToAnswer = {
    question_id: -1,
    answer_id: -1
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

updateTeacher = (teacher, teacher_id) => {
    sendRequest('PUT', '/api/teachers/' + teacher_id, teacher).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

deleteTeacher = (teacher_id) => {
    sendRequest('DELETE', '/api/teachers/' + teacher_id).then(response => {
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

updateStudent = (student, student_id) => {
    sendRequest('PUT', '/api/students/' + student_id, student).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

deleteStudent = (student_id) => {
    sendRequest('DELETE', '/api/students/' + student_id).then(response => {
        if (response.ok) {
            console.log(response);
            document.location.reload(true);
        } else {
            console.log(response);
        }
    });
}

createNewStudentResult = (result) => {
    sendRequest('POST', '/api/tests/result', result).then(response => {
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
let teachers;
let testResult;
let optionNone = `<option value="none"></option>`;

$(document).ready(function(){
    $('#teacher_id').change(function(){
        getTeacherById(this.value).then(teacher => {
            teachers = teacher;
            appendSelectGroup(teacher);
            appendSelectTest(teacher);
        });
    });
});

$(document).ready(function(){
    $('#student_id').change(function(){
        getStudentResultById(this.value).then(student => {
            insertSudentResult(student);
        });
    });
});


getTeacherById = (teacherId) => {
    console.log(teacherId);
    return sendRequest('GET', '/api/teachers/' + teacherId).then(response => {
        if (response.ok) {
            return response.json();
        } else {
            console.log(response);
        }
    });
}

getStudentResultById = (studentId) => {
    return sendRequest('GET', '/api/students/' + studentId + '/result').then(response => {
        if (response.ok) {
            return response.json();
        } else {
            console.log(response);
        }
    });
}

function appendSelectGroup(teacher) {
    let select = document.getElementById('group_id');
    select.disabled = false;
    select.innerHTML = "";
    select.appendChild(document.createRange().createContextualFragment(optionNone));
    for (let i in teacher.groups) {
        let option = document.createElement('option');
        option.value = teacher.groups[i].group_id;
        option.innerHTML = teacher.groups[i].name;
        select.appendChild(option);
    }
}

$(document).ready(function(){
    $('#group_id').change(function(){
        if (document.getElementById("id_owner") !== null ) {
            getTeacherById(Number(document.getElementById("id_owner").getAttribute("value"))).then(teacher => {
                appendSelectStudentsResult(teacher, this.value)
            });
        } else {
            appendSelectStudents(this.value);
            console.log("Хуй соси");
        }
    });
});

function appendSelectStudentsResult(teacher, groupId) {
    console.log(teacher);
    let select = document.getElementById('student_id');
    select.disabled = false;
    select.innerHTML = "";
    select.appendChild(document.createRange().createContextualFragment(optionNone));
    for (let i in teacher.groups) {
        if (teacher.groups[i].group_id === Number(groupId)) {
            for (let j in teacher.groups[i].students) {
                let option = document.createElement('option');
                option.value = teacher.groups[i].students[j].student_id;
                option.innerHTML = teacher.groups[i].students[j].name + " " + teacher.groups[i].students[j].suranme;
                select.appendChild(option);
            }
        }
    }
}

function appendSelectStudents(groupId) {
    let select = document.getElementById('student_id');
    select.disabled = false;
    select.innerHTML = "";
    select.appendChild(document.createRange().createContextualFragment(optionNone));
    for (let i in teachers.groups) {
        if (teachers.groups[i].group_id === Number(groupId)) {
            for (let j in teachers.groups[i].students) {
                let option = document.createElement('option');
                option.value = teachers.groups[i].students[j].student_id;
                option.innerHTML = teachers.groups[i].students[j].name + " " + teachers.groups[i].students[j].surname;
                select.appendChild(option);
            }
        }
    }
}

function appendSelectTest(teacher) {
    let select = document.getElementById('test_id');
    select.disabled = false;
    select.innerHTML = "";
    select.appendChild(document.createRange().createContextualFragment(optionNone));
    for (let i in teacher.tests) {
        let option = document.createElement('option');
        option.value = teachers.tests[i].test_id;
        option.innerHTML = teachers.tests[i].name;
        select.appendChild(option);
    }
}

function hiddenElements() {
    document.getElementById('data_block').hidden = true;
    document.getElementById('break_test').hidden = false;
    createTest();
}

function createTest() {
    let test_block = document.getElementById('test_block');
    for (let i in teachers.tests) {
        if (teachers.tests[i].test_id === Number(document.getElementById("test_id").value)) {
            testResult = teachers.tests[i];
            for (let j in teachers.tests[i].questions) {
                let question = `<div id="${teachers.tests[i].questions[j].question_id}" class="question">
                                    <div class="form-row">
                                        <div class="form-group" id="question_text">
                                            <label>${teachers.tests[i].questions[j].text}</label>
                                        </div>
                                    </div>
                                    <div class="container">
                                        <div class="answers">
                                            ${getAnswers(teachers.tests[i].questions[j])}
                                        </div>
                                    </div>
                                </div>`
                question = document.createRange().createContextualFragment(question);
                test_block.appendChild(question);
            }
        }
    }
}

function getAnswers(answers) {
    let divAnswers = "";
    for (let i in answers.answers) {
        let answer = `<div class="form-check mb-2 answer">
                        <input class="form-check-input defaultCheck" type="checkbox" value="false"
                               id="checkbox_check"
                               onclick="testCheck(this)">
                        <label id="${answers.answers[i].answer_id}">${answers.answers[i].text}</label>
                    </div>`
        divAnswers += answer;
    }
    return divAnswers;
}

function insertSudentResult(studentResult) {
    let tableStudent = document.getElementById("studentResult");
    while (tableStudent.hasChildNodes()) {
        tableStudent.removeChild(tableStudent.lastChild);
    }
    for (let i in studentResult) {
        let row = tableStudent.insertRow(-1)
        row.insertCell(-1).innerHTML = studentResult[i].name;
        row.insertCell(-1).innerHTML = studentResult[i].nameTest;
        row.insertCell(-1).innerHTML = studentResult[i].result;
    }

}