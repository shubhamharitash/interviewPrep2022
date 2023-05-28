Now Todd and Gina have the requirement that they don't want to click the remote. So here is our modified usecase diagram
![[Ch3_ILoveYouYourePerfectNowChange-1682277172528.jpeg]]

We updated the Barkrecognizer code to open the door but it was not closing doors as intended, so we move the code to dog door class because it is the property of the door to open and close not the property of BarkRecognizer or RemoteControl.
![[Ch3_ILoveYouYourePerfectNowChange-1682277976613.jpeg]]

