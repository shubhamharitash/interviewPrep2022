![[TCP-1672715422719.jpeg]]
![[TCP-1672715626262.jpeg]]
![[TCP-1672715825563.jpeg]]
![[TCP-1672715721272.jpeg]]
![[TCP-1672716065282.jpeg]]
File Descriptor here is the state information which tells an incoming tcp segment whether it will be accepted or whether it will be dropped
Both source and destination maintaines this data.
It is of this form
![[TCP-1672716471444.jpeg]]
![[TCP-1672717799863.jpeg]]
![[TCP-1672717937701.jpeg]]
![[TCP-1672719203325.jpeg]]
![[TCP-1672719606745.jpeg]]
#### Flow and Congestion control

![[TCP-1672719863344.jpeg]]
![[TCP-1672719987189.jpeg]]
![[TCP-1672720135503.jpeg]]
Window size here indicates the receiving capabilities of the source.
![[TCP-1672720252107.jpeg]]
![[TCP-1672720376971.jpeg]]
![[TCP-1672720496993.jpeg]]
>FlowControl tells how much **receiver** can handle 
>Congestion control tells how much **network** can handle

![[TCP-1672721236322.jpeg]]
It is  a property of the sender
![[TCP-1672721419395.jpeg]]
![[TCP-1672721544979.jpeg]]
![[TCP-1672721646780.jpeg]]
![[TCP-1672721773839.jpeg]]
Window Size ca be reduced based on this window size

#### NAT
![[TCP-1672732068654.jpeg]]
![[TCP-1672732757942.jpeg]]
If 2 devices are connected to same router, they are part of same network and does not need a public IP to connect.

**Scenario when connecting to a public IP**

![[TCP-1672734120471.jpeg]]
![[TCP-1672734621399.jpeg]]
![[TCP-1672735781837.jpeg]]
We can have sockets in TIME_WAIT state on the client side rather than on the server

![[TCP-1672735907842.jpeg]]
TCP head of line blocking
![[TCP-1672736389660.jpeg]]
Capturing packets
```shell
tcpdump -n -v -i wlo1 src 93.184.216.34 or dst 93.184.216.34 and port 80
```

Todos ans
![[TCP-1672763673890.jpeg]]
