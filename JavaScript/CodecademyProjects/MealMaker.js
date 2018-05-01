let menu = {
    _courses: {
        appetizers: [],
        mains: [],
        desserts: []
    },
    set _appetizers(newAppetizer) {
        this.appetizers.push(newAppetizer);
    },
    get _appetizers() {
        console.log(`The appetizers are ${this.courses[appetizers]}.`);
        return this.appetizers;
    },
    set _mains(newMain) {
        this.mains.push(newMain);
    },
    get _mains() {
        console.log(`The mains are ${this._courses[mains]}.`);
        return this.mains;
    },
    set _desserts(newDessert) {
        this.desserts.push(newDessert);
    },
    get _desserts() {
        console.log(`The desserts are ${this._courses[desserts]}.`);
    },
    get courses() {
        return this._courses;
    },
    addDishToCourse(courseName, dishName, dishPrice) {
        const dish = {dishName, dishPrice};
        this._courses[courseName].push(dish);
    },
    getRandomDishFromCourse(courseName) {
        const dishes = this._courses[courseName];
        const rand = Math.floor(Math.random() * dishes.length);
        return dishes[rand];
    }


};

menu.addDishToCourse('desserts', 'cherry pie', 7);
menu.addDishToCourse('desserts', 'chocolate ice cream', 4);
menu.addDishToCourse('mains', 'chicken cordon bleu', 18);
menu.addDishToCourse('mains', 'mushroom penne', 14);
menu.addDishToCourse('appetizers', 'chicken wings', 10);
menu.addDishToCourse('appetizers', 'mozzarella sticks', 8);

const appetizer = menu.getRandomDishFromCourse('appetizers');
const main = menu.getRandomDishFromCourse('mains');
const dessert = menu.getRandomDishFromCourse('desserts');

const totalPrice = appetizer.dishPrice + main.dishPrice + dessert.dishPrice;
const mealDescription = `For today's meal, I have selected for you an \
appetizer of ${appetizer.dishName},\n a main course of ${main.dishName},\n \
and a dessert of ${dessert.dishName}.`;

console.log(mealDescription);
console.log(`The cost of this meal will be $${totalPrice} before tax and tip.`);
