#### Common-Lib
It is a java library which simplifies given below operations
	1) Connecting to 
		1) Database
		2) Other microservices
	2) Implement kafka in other microservices
	3) Introduces configurable security via yml
	4) Has code for common exception Handlers
	5) Provides a common objectMapper, gson for json related operations
	6) RestTemplate support

Challenges encountered
1) Handling conflicting beans in microservices which implemented commonlib
2) Choosing default settings which are applicable for most microservices to avoid doing configurations in microservices.

Accomplishments of project
1) Reduced p50, p99 + reduced ram for microservices where it was introduced.
2) Made delivering journeys easier due to presence of important functionalities in library itself.

#### Turtlemint Journey
Implemented a redirection based journey backend where leads are managed by Airtel.
Challenges encountered
1) Debugging and correcting partner's redirection url so that it can be used on different platforms(IOS, WEB, ANDROID)
2) Reducing steps in journey to reduce its complexity, decoupling according to usecases.

Accomplishments of project
1) Found and solved an existing bugs which impacts redirection urls.
2) Applied OOPs, LLD conncepts to identify redudant steps, simplify journey,

#### Implementing Retry functionality across all microservices
Initially we didn't had a state in order processes to identify if an order failed due to a tech error or due to a genuine business case failure. 
For identifying such errors introduced a RETRY_FAILED state which can be easily retried via a seperate script or code logic.

#### Visualizing workflows via Mermaid
Created a python script to generate mermaid flowchart diagrams.
Challenges encountered
1) Line breaks, newLines are not directly supported in mermaid, found a solution to rectify that

Accomplishments of project
1) Simplified understanding complex workflows in which multiple nodes, edges and actions are involved.
2) Helps validate workflows without running the workflow.