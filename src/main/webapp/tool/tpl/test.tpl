
{{if isAdmin}}

<h1>{{title}}</h1>
<ul>
    {{each list as value i}}
        <li>���� {{i + 1}} ��{{value}}</li>
    {{/each}}
</ul>

{{/if}}
