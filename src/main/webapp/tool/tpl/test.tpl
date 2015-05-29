
{{if isAdmin}}

<h1>{{title}}</h1>
<ul>
    {{each list as value i}}
        <li>Ë÷Òý {{i + 1}} £º{{value}}</li>
    {{/each}}
</ul>

{{/if}}
