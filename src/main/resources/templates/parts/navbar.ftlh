<#import "login.ftlh" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">A.O.Tester ))</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/take/tests">Пройти тест</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/tests">Тесты</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/">Результаты тестирования</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/students">Обучающиеся</a>
            </li>
        </ul>

        <@l.logout />
    </div>
</nav>