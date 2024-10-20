<div class="markdown-body"><h1 id="учет-сотрудников-в-компании-с-использованием-spring-data">Учет сотрудников в компании с использованием Spring Data</h1>
<h2 id="описание-проекта">Описание проекта</h2>
<p>Данный проект представляет собой приложение для учета сотрудников в компании, реализованное с использованием Spring Data. В приложении предусмотрены сущности <code>Employee</code> и <code>Department</code>, а также возможность работы с проекциями для получения необходимой информации о сотрудниках.</p>
<h2 id="технологии">Технологии</h2>
<ul>
<li>Java</li>
<li>Spring Boot</li>
<li>Spring Data JPA</li>
<li>PostgreSQL</li>
<li>Maven</li>
<li>RESTful API</li>
</ul>
<h2 id="сущности">Сущности</h2>
<h3 id="employee">Employee</h3>
<p>Сущность <code>Employee</code> представляет собой сотрудника компании. Она содержит следующие поля:</p>
<ul>
<li><code>id</code> (Long) — автоматически генерируемый идентификатор сотрудника</li>
<li><code>firstName</code> (String) — имя сотрудника</li>
<li><code>lastName</code> (String) — фамилия сотрудника</li>
<li><code>position</code> (String) — должность сотрудника</li>
<li><code>salary</code> (BigDecimal) — заработная плата</li>
<li><code>department</code> (Department) — ссылка на отдел, к которому принадлежит сотрудник</li>
</ul>
<h3 id="department">Department</h3>
<p>Сущность <code>Department</code> представляет собой отдел компании. Она содержит следующие поля:</p>
<ul>
<li><code>id</code> (Long) — автоматически генерируемый идентификатор отдела</li>
<li><code>name</code> (String) — название отдела</li>
</ul>
<h2 id="репозитории">Репозитории</h2>
<p>Созданы интерфейсы репозиториев для сущностей <code>Employee</code> и <code>Department</code> с использованием Spring Data:</p>
<ul>
<li><code>EmployeeRepository</code> для управления <code>Employee</code></li>
<li><code>DepartmentRepository</code> для управления <code>Department</code></li>
</ul>
<h2 id="проекции">Проекции</h2>
<p>Реализована проекция для сущности <code>Employee</code> в виде интерфейса:</p>
<h3 id="employeeprojection">EmployeeProjection</h3>
<pre><code class="java language-java hljs"><span class="hljs-keyword">public</span> <span class="hljs-keyword">interface</span> <span class="hljs-title class_">EmployeeProjection</span> {
    String <span class="hljs-title function_">getFullName</span><span class="hljs-params">()</span>;
    String <span class="hljs-title function_">getPosition</span><span class="hljs-params">()</span>;
    String <span class="hljs-title function_">getDepartmentName</span><span class="hljs-params">()</span>;
}</code><button class="copy-ai-code" onclick="copyAICode(this)"><svg stroke="currentColor" fill="none" stroke-width="2" viewBox="0 0 24 24" stroke-linecap="round" stroke-linejoin="round" class="h-4 w-4" height="1em" width="1em" xmlns="http://www.w3.org/2000/svg"><path d="M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2"></path><rect x="8" y="2" width="8" height="4" rx="1" ry="1"></rect></svg> <span class="label-copy-code">Копировать</span></button></pre>
<p>Методы проекции позволяют получить следующую информацию о сотруднике:</p>
<ul>
<li><code>getFullName()</code> — полное имя сотрудника</li>
<li><code>getPosition()</code> — должность сотрудника</li>
<li><code>getDepartmentName()</code> — название отдела, к которому принадлежит сотрудник</li>
</ul>
<h2 id="rest-контроллер">REST-контроллер</h2>
<p>Создан REST-контроллер для обработки запросов, связанных с управлением сотрудниками и отделами. Контроллер предоставляет следующие API-методы:</p>
<ul>
<li><code>GET /employees</code> — получить список всех сотрудников</li>
<li><code>POST /employees</code> — добавить нового сотрудника</li>
<li><code>PUT /employees/{id}</code> — обновить информацию о сотруднике по ID</li>
<li><code>DELETE /employees/{id}</code> — удалить сотрудника по ID</li>
<li><code>GET /departments</code> — получить список всех отделов</li>
<li><code>POST /departments</code> — добавить новый отдел</li>
</ul>
<h2 id="сервис">Сервис</h2>
<p>Создан сервисный класс для управления операциями CRUD (создание, чтение, обновление, удаление) для сотрудников и отделов. Сервис отвечает за бизнес-логику и взаимодействие с репозиториями.</p>
<h2 id="тестирование">Тестирование</h2>
<p>Тесты включены для классов сервисов, что позволяет проверить правильность выполнения основных операций. Для запуска тестов используйте следующую команду:</p>
<pre><code class="bash language-bash hljs">mvn <span class="hljs-built_in">test</span></code></pre>
<h2 id="запуск-приложения">Запуск приложения</h2>
<p>Для запуска приложения используйте команду:</p>
<pre><code class="bash language-bash hljs">mvn spring-boot:run</code></pre>
<h2 id="заключение">Заключение</h2>
<p>Это приложение для учета сотрудников демонстрирует использование Spring Data, проекций и RESTful API для управления сущностями. Проект легко расширяем и может быть доработан под конкретные требования бизнеса.</p></div>
