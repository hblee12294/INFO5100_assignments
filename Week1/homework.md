
# Homework

## 1. Hiking
### 1.1 Rent a ReachNow to drive to mountain rainier on weekends with friends
#### Objects and Behaviors:


**Driver**

&emsp;*data*: name, phoneNumber, email, address, driveLicense, creditCard, destination, friendsList, passWord

&emsp;*behaviors*: openWeb, signUpWeb, signInWeb, pickCarOnline, getCar, pickUpPassenger, drive, move, useCreditCard

**ReachNow**

&emsp;*data*: url, userData, carList, confirmMsg, emplyee

&emsp;*behavior*: verifyUser, updateUserData, buildMsg, sendMsg, sendEmplyee

**Phone**

&emsp;*data*: dataTraffic

&emsp;*behavior*:  receiveMsg, sendMsg, setNavigation

**CreditCard**

&emsp;*data*: holderName, cardNumber, CVV, signature, expirationDate

&emsp;*behavior*: transaction

**GoogleMap**

&emsp;*data*: starting, destination, GPSData

&emsp;*behavior*: locateNow, search, navigate

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

&emsp;*data*: gases, location

&emsp;*behavior*: fillGas, charge

**Gas**

&emsp;*data*: price, level, usage

**User**

&emsp;*behavior*: pay, chooseGas

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

&emsp;*data*: name, location, menu, food

&emsp;*behavior*: serveFood, charge

**Customer**

&emsp;*data*: foodChosen

&emsp;*behavior*: order, getFood, checkout, eat 

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

&emsp;*data*: tickets, stock

&emsp;*behavior*: charge, checkStock, giveTicket

**Tourist**

&emsp;*data*: name, friendsList, tickets

&emsp;*behavior*: pay, buyTicket , getTicket, enterPark

**Ticket**

&emsp;*data*: price, status

**Gate**

&emsp;*data*: ticketsData

&emsp;*behavior*: verifyTickets

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

&emsp;*data*: rooms, location, visitorData

&emsp;*behavior*: checkRoom, updateRoom, charge, giveKey

**Room**

&emsp;*data*: type, size, price, availability

**Visitor**

&emsp;*data*: name, phoneNumber, gender, roomChosen

&emsp;*behavior*: checkIn, chooseRoom, checkOut, live, cancelRoom, pay, returnKey 



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

**Organizer**

&emsp;*data*: name, purpose, budget, initCompanyList,companyList, studentList

&emsp;*behavior*: schemeCareerFair, propaganda, layoutSite, inviteCompany, updateCompany, getApplication, updateStudent, finish

**CareerFair**

&emsp;*data*: startTime, endTime, location


**Company**

&emsp;*data*: name, positions, join

&emsp;*behavior*: giveInterview, introduce, updateCandidate ,getCV, 

**Position**

&emsp;*data*: name, candidateList, description

**Student**

&emsp;*data*: name, gender, photo, phoneNumber, school, email, GPA, CV, targetCompany, registerForm

&emsp;*behavior*: register, makeCV, sendCV, takeInterview, updateTargetCompany, 

#### Sequence of Flow:

	Organizer organizer
	CareerFair careerFair
	Company initCompanyList

	careerFair = orgaizer.schemeCareerFair(careerFair, initCompanyList)

	for compy in initCompanyList
		organizer.inviteCompany(compy)

		if compy.join is true
			organizer.updateCompany -> compy
		end
	end

	organizer.propaganda -> companyList

	Student stds[]
	for std in stds
		std.register -> name, gender, photo, phoneNumber, school, email : registerForm
		organizer.getApplication -> registerForm
		organizer.updateStudent
	end 

	organizer.layoutSite(careerFair)

	Time currentDay
	while currentDay > careerFair.startTime && currentDay < careerFair.endTime
		for std in stds
			for tCompy in targetCompany
				std.sendCV -> tCompy
				std.updateTargetCompany -> tCompy
			end
		end

		for compy in organizer.companyList
			for candidate in compy.postions.candidateList
				candidate.takeInterview
				compy.giveInterview -> candidate : feedback
				compy.updateCandidate -> candidateList, feedback
			end
	end

	organizer.finish

***
## 3. Order Pizza from Pizza Hut
#### Objects and Behaviors:

**Restaurant**

&emsp;*data*: name, location, employees, menu

&emsp;*behavior*: getOrder, makePizza, servePizza, charge

**Pizza**

&emsp;*data*: price, ingredients, weight, size

**Customer**

&emsp;*data*: orderNumber

&emsp;*behavior*: orderPizza, addIngredient, checkout, eatPizza

**CreditCard**

&emsp;*data*: holderName, cardNumber, CVV, signature, expirationDate

&emsp;*behavior*: transaction

#### Sequence of Flow:

	Restaurant pizzaHut
	Customer lee
	CreditCard card

	while true
		lee.orderPizza -> menu : order
		order = lee.addIngredient(order)
		pizzaHut.getOrder -> order : orderStatus
		if orderStatus is true
			pizzaHut.makePizza
			pizzaHut.servePizza
			break
		else
			"The pizza you ordered has been sold out, sorry."
		end
	end

	lee.eatPizza

	pizzaHut.charge -> order : bill
	lee.checkout -> bill, card : receipt

***
## 4. Design a code sharing platform (eg: Github).
#### Objects and Behaviors:

**GitHub**

&emsp;*data*: url, logPage, pages, userData, accountData 

&emsp;*behavior*: signUp, signIn, logout, updateUserData, updateAccounts, 

**Accounts**

&emsp;*data*: holder, repositories

&emsp;*behavior*: updateRpositories

**Repository**

&emsp;*data*: holder, name, data, forkTimes

&emsp;*behavior*:  updateData


**User**

&emsp;*data*: name, email, passWord, codes

&emsp;*behavior*: push, pull, fork, renameRepositories


#### Sequence of Flow:

	Github gitHub
	User lily
	Accounts accountOfLily
	
	lily.signUp -> name, email, passWord, accountOfLily, gitHub : accountOfLily

	while true
		lily.signIn -> email, passWord, gitHub -> gitHub.logPage
		if logPage is true
			gitHub.jumpToAccountPage -> accountOfLily
			break
		else
			"Your account or password is not right, try again."

	lily.push -> code, repository
	repository.updateData -> code

	lily.pull -> repositoy.name
	accountOfLily.updateRepositories

	lily.folk -> accountOfJack.repository[name].name
	accountOfLily.updateRepositories
	accountOfJack.repository[name].forkTime++

	Repository repository
	lily.renameRepositories -> repository.name

***
## 5. Design a soft-drink/snacks vending machine.
#### Objects and Behaviors:

**VendingMachine**

&emsp;*data*: drinks, snacks, supplierList, location, paymentInfo

&emsp;*behavior*: checkStock, stockAlert, updateStock, updateAmount, sendMsfToSupplier, showAmount, chargeProcess, cancel, pourItems

**Customer**

&emsp;*data*: drinkChosen, snackChosen

&emsp;*behavior*: pushButton, payWithCard, payWithPayPal, payWithCash, pushCancel, pushConfirm 

**Supplier**

&emsp;*data*: supplyList, VendingMachineLocations

&emsp;*behavior*: receiveMsg, locateVendingMachine, supplyItem

**Drink**

&emsp;*data*: name, type, stock, volume, price, supplier, id

**Snack**

&emsp;*data*: name, type, stock, newWeight, price, supplier, id

#### Sequence of Flow:

	VendingMachine venMachine
	Customer alen

	alen.chooseFood : drinkChosen, snackChosen
	for drink in drinkChosen
		alen.pushButton -> drink.id
		venMachine.checkStock -> drink.id, snack.stock : stockStatus
		if stockStatus is true
			updateStock -> drink
			updateAmount -> drink
		else
			drink.name + "sold out"
		end
	end
	for snack in snackChosen
		alen.pushButton -> snack.id
		venMachine.checkStock -> snack.id, snack.stock : stockStatus
		if stockStatus is true
			updateStock -> snack
			updateAmount -> snack
		else
			snack,name + "sold out"
		end
	end

	venMachine.showAnount -> paymentInfo
	if alen.pushConfirm is true
		venMacine.paymentProcess -> payment = alen.payWithCash | payWithCard | payWithPayPal : paymentStatus
	else if alen.pushCancel
		venMachine.cancel
		"Thanks, see you next time."
	else
		venMachine.cancel
		"Time out, choose your food again."
	end

	if paymentStaus is true
		venMachine.pourItems
		"Thanks, enjoy!"
	else
		venMachine.cancel
		"Payment failure, choose items again."





