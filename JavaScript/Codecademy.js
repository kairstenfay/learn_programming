let Airplane = {};

Airplane.myAirplane = "StarJet";

module.exports = Airplane;

// ========================

const Airplane = require('./1-airplane.js');

function displayAirplane() { 
	console.log(Airplane.myAirplane);
}

displayAirplane()

// =========================

let Airplane = {};

module.exports = {
  myAirplane: "CloudJet",
  displayAirplane: function () { 
		return this.myAirplane;
  }
}

// ===========================

const Airplane = require('./2-airplane.js');

console.log(Airplane.displayAirplane());




const someFunc = variable => variable * 2;

const someOtherFunc = (a, b) => { 
	a += b;
	return `An ${a}.`;
};



