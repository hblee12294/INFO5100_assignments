
# Homework

## 1. Hiking
### 1.1 Rent a ReachNow to drive to mountain rainier on weekends with friends
#### Objects and Behaviors:

**Driver**
	*data*: name, phoneNumber, email, address, driveLicense, creditCard, destination, friendsList, passWord
	*behaviors*: openWeb, signUpWeb, signInWeb, pickCarOnline, getCar, pickUpPassenger, drive, move, useCreditCard

**ReachNow**
	*data*: url, userData, carList, confirmMsg, emplyee,    
	*behavior*: verifyUser, updateUserData, buildMsg, sendMsg, sendEmplyee

**Phone**
	*data*: dataTraffic
	*behavior*:  receiveMsg, sendMsg, setNavigation

**CreditCard**
	*data*: holderName, cardNumber, CVV, signature, expirationDate
	*behavior*: transaction

**GoogleMap**
	*data*: starting, destination, GPSData
	*behavior*: locateNow, search, navigate

#### Sequence of Flow: 

	Driver sam
	Phone phoneOfSam
	GoogleMap Gmap
	CreditCard card
	ReachNow webRN

	sam.openWeb -> webRN.url : webStatus
	if webStatus is true
		webRN.verrifyUser -> sam : logStatus
		if logStatus is not true
			sam.signUpWeb -> webRN
			webRN.updateUserData
		end

		sam.signInWeb -> email, passWord : logStatus
		sam.pickCarOnline -> webRN.carList : carOfSam
		webRN.buidMsg -> carOfSam : confirmMsg
		webRN.sendMsg -> confirmMsg, phoneOfSam
		webRn.sendEmployee : employeeA

		phoneOfSam.receiveMsg -> confirmMsg : carLocation
		sam.move -> carLocation
		sam.getCar -> emplyeeA 

		Gamp.locateNow : locationNow
		phone.setNavigation -> Gamp, locationNow, sam.destination : route
		sam.drive -> route 
	end

### 1.2 On the way, fill the gas
#### Objects and Behaviors:

**GasStation**
	*data*: gases, location
	*behavior*: fillGas, charge

**Gas**
	*data*: price, level, usage

**User**
	*behavior*: pay, chooseGas

#### Sequence of Flow: 

	GasStation station

	Gamp.locateNow : locationNow
	phone.setNavigation -> Gamp, locationNow, station.location : route
	sam.drive -> route

	User user = new User(sam)
	Gas gas
	user.chooseGas -> gas.level : gasChosen
	staion.fillGas -> gasChosen
	station.charge -> gasChosen.price, gasChosen.level, gasChosen.usage : bill
	user.pay -> card, bill : receipt

	phone.setNavigation -> Gamp, locationNow, sam.location : route
	sam.drive -> route


### 1.3 On the way, eat at restaurant for lunch
#### Objects and Behaviors:

**Restaurant**
	*data*: name, location, menu, food
	*behavior*: serveFood, charge

**Customer**
	*data*: foodChosen
	*behavior*: order, getFood, checkout, eat 

#### Sequence of Flow: 

	Restaurant chipotle

	Gamp.locateNow : locationNow
	phone.setNavigation -> Gamp, locationNow, chipotle.location : route
	sam.drive -> route

	Customer customer = new Customer(sam)
	customer.order -> menu : a set of food, bill
	customer.checkout -> bill, card : reciept 
	chipotle.serveFood -> a set of food
	customer.getFood : foodChosen
	customer.eat -> foodChosen

	phone.setNavigation -> Gamp, locationNow, sam.location : route
	sam.drive -> route

### 1.4 Buy the ticket to get into the park
#### Objects and Behaviors:

**TicketHouse**
	*data*: tickets, stock
	*behavior*: charge, checkStock, giveTicket

**Tourist**
	*data*: name, friendsList, tickets
	*behavior*: pay, buyTicket , getTicket, enterPark

**Ticket**
	*data*: price, status

**Gate**
	*data*: ticketsData
	*behavior*: verifyTickets

#### Sequence of Flow: 

	Tourist tst = new Tourist(sam)
	TicketsHouse tHouse

	tst.buyTicket -> numberOf(friendsList)+1 : order
	tHouse.checkstock -> order : stockStatus
	if stockStatus is true
		tHouse.charge -> order : bill
		tst.pay -> bill, card : receipt
		tHouse.giveTicket : a set of tickets
		tst.getTicket -> a set of tickets
	else
		"The ticket stock is not enough, please go back, sorry."
	end

	Gate gate
	gate.verify -> tst.tickets, ticketsData : checkStatus
	if checkStatus is true
		"Welcome!"
		tst.enterPark
	else
		"Your tickets are not valid, please consult ticket hourse."
	end 


### 1.5 Book a hotel or check in the hotel
#### Objects and Behaviors:

	**Hotel**
		*data*: rooms, location, visitorData
		*behavior*: checkRoom, updateRoom, charge, giveKey

	**Room**
		*data*: type, size, price, availability

	**Visitor**
		*data*: name, phoneNumber, gender, roomChosen
		*behavior*: checkIn, chooseRoom, checkOut, live, cancelRoom, pay, returnKey 



#### Sequence of Flow:

	Hotel ibis

	Gamp.locateNow : locationNow
	phone.setNavigation -> Gamp, locationNow, ibis.location : route
	sam.drive -> route

	Visitor vst = new Visitor(sam) 

	loop
		vst.checkIn -> name, phoneNumber, gender, numberOf(sam.friendList)+1, roomChosen, visitorData : order
		ibis.checkRoom -> rooms, order : roomAvailability 
		if roomAvailability is true
			ibis.updateRoom -> order
			ibis.giveKey : keys
			break
		else
			"The room you choose is not available now, please choose again."
		end
	end

	vst.live -> keys

	vst.checkOut : days
	vst.returnKey
	ibis.charge -> days, vst.roomChosen.price : bill
	bst.pay -> card, bill : receipt

***
## 2. Organise a career fair(Suppose you are the organiser)
#### Objects and Behaviors:

**Organiser**
	*data*:
	*behavior*:

#### Sequence of Flow:


## 3. Order Pizza from Pizza Hut

## 4. Design a code sharing platform (eg: Github).

## 5. Design a soft-drink/snacks vending machine.