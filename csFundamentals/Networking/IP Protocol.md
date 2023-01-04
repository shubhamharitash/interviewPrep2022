For creating a connection from server to host we need 3 things
1) source and destiation ips
2) subnet mask
3) gateway(router ip)

## ICMP

ttl denotes numbers of hops which can pe performed before reaching the server

#### traceroute
![[IP Protocol-1672359049226.jpeg]]

![[IP Protocol-1672360107376.jpeg]]

#### IP Packet
![[IP Protocol-1672360571053.jpeg]]
![[IP Protocol-1672361417501.jpeg]]

#### ARP

![[IP Protocol-1672363944846.jpeg]]
ARP poisioning: for source to know destination mac address it broadcasts msg to all devices in the network. Anyone can fake to be the gateway

![[IP Protocol-1672364587413.jpeg]]
#### Using network commands
**tcpdump**
![[IP Protocol-1672654050074.jpeg]]
![[IP Protocol-1672654225184.jpeg]]

filtering in tcpdump
```shell
tcpdump -n -i wlo1 src 216.58.200.206  -v
```
![[IP Protocol-1672655487306.jpeg]]
![[IP Protocol-1672655594119.jpeg]]

#### Routing Example
![[IP Protocol-1672656940520.jpeg]]
1) A -> B
	1) ARP initiated by A
	2) Reply by B
	3) Send message to B
2) D -> X
	1) ARP initiated by D
	2) Node not in subnet so message send to gateway
	3) Gateway routes the message to another network connected to it
3) B -> G (Will become more clear as course progesses)
	1) ARP initiated by B
	2) Node not in subnet so message send to gateway
	3) Gateway doesn't has any other connected networks, so it uses public ip to send message to ISP
	4) ISP connects to G