Here system is developer and user is developer/manager.
#### Requirement
1) Optimize bumblebee to use less resources
2) Add support for using multiple functions on a particular node in json, or on a complete parameter(request, response, header, path param, query param etc.)

#### Usecase 1
1) Application is started by user.
2) Identify resources consumed by the application
3) Identify code in application which is consuming most resources
4) Find and implement optimizations for that piece of code.
5) Test then restart application for optimizations to take effect.
6) Perform steps 2 - 5 until requried optimization is not achived

#### Usecase 2
1) User sends requests to create required evaluator configs.
2) User sends requests to create required project configs.
3) User send request to create service config which has feature to apply evaluator config functions at a node or on a complete parameter(request, response, header, path param, query param etc.) in the requested order
For eg: if config for a node is 
`[func1, func2, func3]` then it is applied as `func3(func2(func1(input)))`.
4) User send requests for transformation and receive required response.