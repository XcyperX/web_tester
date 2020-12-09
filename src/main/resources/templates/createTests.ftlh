<#import "parts/common.ftlh" as c>

<@c.page>
    <div class="container">
        <button class="btn btn-primary mb-2" type="button" data-toggle="collapse" data-target="#listStudents"
                aria-expanded="false" aria-controls="collapseExample">
            Создать тест
        </button>
        <div class="collapse mb-2" id="listStudents">
            <div class="card card-body">
                <div class="container">
                    <input id="id_owner" type="hidden" name="id_owner" value="${teacher}">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Создать тест</label>
                            <input id="nameTest" type="text" name="nameTest" class="form-control"
                                   placeholder="Введите название теста">
                        </div>
                    </div>
                    <div class="questions">
                        <div class="question">
                            <div class="form-row">
                                <div class="form-group">
                                    <label>Введите вопрос</label>
                                    <input id="textQuestion" type="text" name="textQuestion"
                                           class="form-control textQuestion"
                                           placeholder="Введите текст вопроса">
                                </div>
                            </div>
                            <div class="container">
                                <div class="answers">
                                    <div class="form-check mb-2 answer">
                                        <input class="form-check-input defaultCheck" type="checkbox" value="false"
                                               id="checkbox_check"
                                               onclick="testCheck(this)">
                                        <input id="textAnswer" type="text" name="textAnswer"
                                               class="form-control textAnswer"
                                               placeholder="Введите ответ">
                                    </div>
                                </div>
                                <div class="form-group col-md-6">
                                    <input class="btn btn-primary mb-4" type="button" onclick="addAnswers()"
                                           value="Добавить ответ">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input class="btn btn-primary mb-4" type="button" onclick="addQuestions()"
                                   value="Добавить вопрос">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input class="btn btn-primary mb-4" type="button" onclick="submitNewTest()"
                                   value="Создать тест">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="accordion" id="accordionExample">
            <#list tests as test>
                <div class="card">
                    <div class="card-header" id="heading_${test.id}">
                        <h5 class="mb-0">
                            <button class="btn btn-link" type="button" data-toggle="collapse"
                                    data-target="#collapse_${test.id}" aria-expanded="true"
                                    aria-controls="collapse_${test.id}">
                                ${test.name}
                            </button>
                        </h5>
                    </div>

                    <div id="collapse_${test.id}" class="collapse" aria-labelledby="heading_${test.id}"
                         data-parent="#accordionExample">
                        <div class="card-body">
                            <form id="createQuestions" name="createTest">
                                <ul class="list-unstyled">
                                    <#list test.questions as question>
                                    <li>${question.text}
                                        <ul>
                                            <#list question.answers as answer>
                                                <#if answer.isCorrect == true>
                                                    <li><mark>${answer.text}</mark></li>
                                                <#else>
                                                    <li>${answer.text}</li>
                                                </#if>
                                            </#list>
                                        </ul>
                                    </li>
                                    </#list>
                                </ul>
                            </form>
                        </div>
                    </div>
                </div>
            </#list>
        </div>
    </div>
</@c.page>