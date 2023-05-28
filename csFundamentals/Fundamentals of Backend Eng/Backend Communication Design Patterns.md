## What we studied
1) Basic request/ response pattern
2) Different communication patterns which certain advantages depending on use case over simple request response pattern
	1) Push
		1) data is pushed by server, client doesn't require anything
	2) Poll(Short Poll)
		1) client keeps on polling using the received handle until it receives data
	3) Long Poll
		1)  here polling is done by server locally instead of the client.
	4) [[Server Side Events]]
		1) Here the connection is not terminated. 
		2) Instead response is streamed unidirectionally where end of response is not given
		3) Timeouts can be there, it is easily supported using http1.1 and above, doesn't require websockets.
	5) Publish Subscribe(Kafka)
3) Multiplexing vs Demultiplexing
	1) Multiplexing(HTTP/2)
		1) Mutiple connection to a single stream
	2) Demultiplexing
		1) single stream to multiple connections
4) Stateless vs Stateful
5) Sidecar pattern
	1) Here we use proxy, reverse proxy to delegate the responsibility of protocols to them.