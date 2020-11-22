<#import "parts/common.ftlh" as c>

<@c.page>
<div class="container">
    <form id="createTest" name="createTest">
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Создать тест</label>
                <input id="name" type="text" name="groupName" class="form-control" placeholder="Введите название теста">
            </div>
        </div>
        <div class="container">
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label>Введите вопрос</label>
                    <input id="name" type="text" name="groupName" class="form-control" placeholder="Введите текст вопроса">
                </div>
            </div>
            <div class="container">
                <div class="form-check">
                    <input class="form-check-input align-top" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                    <input id="name" type="text" name="groupName" class="form-control" placeholder="Введите текст вопроса">
                </div>
                <div class="form-group col-md-6">
                    <input class="btn btn-primary mb-4" type="button" onclick="submitNewTest()" value="Добавить вопрос">
                </div>
            </div>

        <div class="form-row">
            <div class="form-group col-md-6">
                <input class="btn btn-primary mb-4" type="button" onclick="submitNewTest()" value="Создать тест">
            </div>
        </div>
    </form>
</div>
<div class="container">
        <div class="accordion" id="accordionExample">
            <#list tests as test>
            <div class="card">
                <div class="card-header" id="heading_${test.id}">
                    <h5 class="mb-0">
                        <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapse_${test.id}" aria-expanded="true" aria-controls="collapse_${test.id}">
                            ${test.name}
                        </button>
                    </h5>
                </div>

                <div id="collapse_${test.id}" class="collapse" aria-labelledby="heading_${test.id}" data-parent="#accordionExample">
                    <div class="card-body">
                        <form id="createQuestions" name="createTest">
                            <div class="form-group col-md-6">
                                <a href="/test/${test.id}" class="btn btn-primary mb-4" type="button">Добавить вопросы</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            </#list>
        </div>
</div>
</@c.page>