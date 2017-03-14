<head>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

</head>

<body>
	<h1>NIKONIKOS</h1>
	<table class="table table-bordered table-hover">
		<tr>
			<#list items as item>
				<#list sortedFields as field>
					<#list item?keys as key>
						<#if key == field>
							<th>${key}</th>
						</#if>
					</#list>
				</#list>
				<#break>
			</#list>
		</tr>
		<#list items as item>
			<tr>
				<#list sortedFields as field>
					<#list item?keys as key>
						<#if key == field>
							<#if item[key]?is_boolean>
								<td>${item[key]?c}</td>
							<#else>
								<td>${item[key]}</td>
							</#if>
						</#if>
					</#list>
				</#list>
			</tr>
		</#list>
	</table>
</body>