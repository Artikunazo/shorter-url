<task>
<title_task>Improve shorter url application</title_task> 
<description> 
	You are a Senior software engineer. Analyze and improve the current implementation of the URL shortener application. The application is built with Angular for the frontend and Spring Boot for the backend. The application is containerized with Docker and uses MySQL as the database. The goal is to improve the application by following modern coding rules and best practices. 
</description>

<tasks>
	<step>
		<title>Analyze current application state</title>
		<task_description>
		Review the current implementation of the URL shortener application, including:
		- Back-end code (Java/Spring Boot) and database schema
		- Front-end code (Angular) and API integration
		- Database schema
		- Docker configuration
		</task_description>
		<expected_output>
			<output_type>checklist</output_type>
			<checklist>
				<item>Current architecture documented</item>
				<item>Database schema reviewed</item>
				<item>API endpoints documented</item>
				<item>Frontend arquitecture</item>
				<item>Docker configuration reviewed</item>
			</checklist>
		</expected_output>
		</step>
		<step>
		<title>Enhance Frontend implementation</title>
		<task_description>
		- Analyze current implementation of the Angular in frontent from previous step context
		- Migrate angular to version 22 without breaking changes in UI and user experience
		- Apply a redesign of interface inspired from Kubuntu Plasma 6 theme (search in web)
		- Ensure compatibility with responsive design, work with mobile, tablet and desktop devices.
		- Use angular strenghts to improve performance: signals, signal forms, rxjs, lazy loading, tree shaking, etc.
		- Keep current state managment integration
		- Delete code unused from current codebase.
		- Create documentation of the codebase with diagram (flow chart) for an overview of how the application works.
		- Use PrimeNg framework (free version)
		- Use tailwind free components
		</task_description>
		<expected_output>
			<output_type>documentation</output_type>
			<documentation>
				<item>Frontend documentation</item>
				<item>Code updated</item>
				<item>Flow chart</item>
				<item>New UI implemented</item>
			</documentation>
		</expected_output>
		</step>
</tasks>

<step>
<title>Use modern coding rules for backend and frontend</title>
<task_description>
- Follow coding rules and best practices of Spring Boot, Angular and Docker
- Use Clean code, Yagni, SOLID and reactive programming principles
- Avoid complexity and redundancy
</task_description>
<expected_output>
<output_type>documentation</output_type>
<documentation>
<item>Coding rules documented</item>
<item>Code updated</item>
</documentation>
</expected_output>
</step>

<constraints>
- Do not change the backend implementation
- Do not modify system files
- Do not create new files in backend
- Do not change database schema
</constraints>

<conditions>
- Use only frontent codebase
- use pnpm instead of npm
- Create a plan and say it me
- Use Primeng and tailwind free
- If somerhing is applied, ignore it.
</conditions>
</task>