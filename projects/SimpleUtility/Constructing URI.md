We will use `UriComponentsBuilder` to construct Uri for our use

Features
1) Using standalone string
	1) If a single string is supplied for a uri, we will not perform any operation on it
2) Completely from config
User will supply a config which has complete details for a uri to be constructed
```json
{  
  "scheme": "https",  
  "host": "www.example.com",  
  "port": "8080",  
  "pathSegment": [  
    "path",  
    "to",  
    "resource"  
  ],  
  "queryParam": {  
    "param1": [  
      "value1",  
      "value2"  
    ],  
    "param2": 12,  
    "param3": "value3"  
  },  
  "fragment": "resource1"  
}
```
3) Combo of config, provided uri
	1) uri will be used to initialize `UriComponentsBuilder`
	2) any details provided in config will be used to add or update the details in the uri.
4) Generating config from a given URI String
	1) UriComponents can be used to fetch details for config of the generated uri.

