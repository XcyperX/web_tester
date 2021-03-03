<#import "parts/common.ftlh" as c>

<@c.page>
    <div id="data_block" class="container">
        <label>Выберите преподавателя</label>
        <select id="teacher_id" class="form-control mb-4">
            <option value="none"></option>
            <#list teachers as teacher>
                <option value="${teacher.id}">${teacher.name} ${teacher.surname}</option>
            </#list>
        </select>

        <label>Выберите группу</label>
        <select id="group_id" class="form-control mb-4" disabled>
        </select>

        <label>Выберите студента</label>
        <select id="student_id" class="form-control mb-4" disabled>
        </select>

        <label>Выберите тест</label>
        <select id="test_id" class="form-control mb-4" disabled>
        </select>
        <div>
            <input class="btn btn-primary mb-4" type="button" onclick="hiddenElements()"
                   value="Начать тест">
        </div>
    </div>
    <div id="test_block" class="container">

    </div>
    <div>
        <input  id="break_test" class="btn btn-primary mb-4" type="button" onclick="submitNewTestResult()"
               value="Завершить тест" hidden>
    </div>
</@c.page>