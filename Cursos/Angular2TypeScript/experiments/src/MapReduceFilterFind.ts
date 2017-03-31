// Code goes here

// oodlify :: String -> String
function oodlify(s) {
    return s.replace(/[aeiou]/g, 'oodle');
}

function izzlify(s) {
    return s.replace(/[aeiou]+/g, 'izzle');
}


const input = [
    'John',
    'Paul',
    'George',
    'Ringo',
];

//with while
let i = 0;
const len = input.length;
let output = [];
while (i < len) {
    let item = input[i];
    let newItem = oodlify(item);
    output.push(newItem);
    i = i + 1;
}

//with for
output = [];
for (let i = 0; i < len; i = i + 1) {
    let item = input[i];
    let newItem = oodlify(item);
    output.push(newItem);
}

//with for..of
output = [];
for (let item of input) {
    let newItem = oodlify(item);
    output.push(newItem);
}


const fellowship = [
    'frodo',
    'sam',
    'gandalf',
    'aragorn',
    'boromir',
    'legolas',
    'gimli',
];

const band = [
    'John',
    'Paul',
    'George',
    'Ringo',
];

let bandoodle = [];
for (let item of band) {
    let newItem = oodlify(item);
    bandoodle.push(newItem);
}

let floodleship = [];
for (let item of fellowship) {
    let newItem = oodlify(item);
    floodleship.push(newItem);
}


function oodlifyArray(input) {
    let output = [];
    for (let item of input) {
        let newItem = oodlify(item);
        output.push(newItem);
    }
    return output;
}

function izzlifyArray(input) {
    let output = [];
    for (let item of input) {
        let newItem = izzlify(item);
        output.push(newItem);
    }
    return output;
}


bandoodle = oodlifyArray(band);
floodleship = oodlifyArray(fellowship);


function mapFor(f, a) {
    let output = [];
    for (let item of a) {
        output.push(f(item));
    }
    return output;
}

function mapRecurs(f, a) {
    if (a.length === 0) { return []; }
    return [f(a[0])].concat(mapRecurs(f, a.slice(1)));
}


bandoodle     = band.map(oodlify);
floodleship   = fellowship.map(oodlify);
let bandizzle     = band.map(izzlify);
let fellowshizzle = fellowship.map(izzlify);



let heroes = [
    {name: 'Hulk', strength: 90000},
    {name: 'Spider-Man', strength: 25000},
    {name: 'Hawk Eye', strength: 136},
    {name: 'Thor', strength: 100000},
    {name: 'Black Widow', strength: 136},
    {name: 'Vision', strength: 5000},
    {name: 'Scarlet Witch', strength: 60},
    {name: 'Mystique', strength: 120},
    {name: 'Namora', strength: 75000},
];

let strongest = {strength: 0};
for (let hero of heroes) {
    if (hero.strength > strongest.strength) {
        strongest = hero;
    }
}

let combinedStrength = 0;
for (let hero of heroes) {
    combinedStrength += hero.strength;
}

function greaterStrength(champion, contender) {
    return (contender.strength > champion.strength) ? contender : champion;
}

function addStrength(tally, hero) {
    return tally + hero.strength;
}

const initialStrongest = {strength: 0};
let working = initialStrongest;
for (let hero of heroes) {
    working = greaterStrength(working, hero);
}
strongest = working;

const initialCombinedStrength = 0;
working = initialCombinedStrength;
for (let hero of heroes) {
    working = addStrength(working, hero);
}
combinedStrength = working;

function reduce(f, initialVal, a) {
    let working = initialVal;
    for (let item of a) {
        working = f(working, item);
    }
    return working;
}

const strongestHero = heroes.reduce(greaterStrength, {strength: 0});
combinedStrength = heroes.reduce(addStrength, 0);

let newHeroes = [
    {name: 'Hulk', strength: 90000, sex: 'm'},
    {name: 'Spider-Man', strength: 25000, sex: 'm'},
    {name: 'Hawk Eye', strength: 136, sex: 'm'},
    {name: 'Thor', strength: 100000, sex: 'm'},
    {name: 'Black Widow', strength: 136, sex: 'f'},
    {name: 'Vision', strength: 5000, sex: 'm'},
    {name: 'Scarlet Witch', strength: 60, sex: 'f'},
    {name: 'Mystique', strength: 120, sex: 'f'},
    {name: 'Namora', strength: 75000, sex: 'f'},
];

let femaleHeroes = [];
for (let hero of newHeroes) {
    if (hero.sex === 'f') {
        femaleHeroes.push(hero);
    }
}

let superhumans = [];
for (let hero of newHeroes) {
    if (hero.strength >= 500) {
        superhumans.push(hero);
    }
}


function isFemaleHero(hero) {
    return (hero.sex === 'f');
}

function isSuperhuman(hero) {
    return (hero.strength >= 500);
}

femaleHeroes = [];
for (let hero of newHeroes) {
    if (isFemaleHero(hero)) {
        femaleHeroes.push(hero);
    }
}

superhumans = [];
for (let hero of newHeroes) {
    if (isSuperhuman(hero)) {
        superhumans.push(hero);
    }
}

function filter(predicate, arr) {
    let working = [];
    for (let item of arr) {
        if (predicate(item)) {
            working = working.concat(item);
        }
    }
}

femaleHeroes = filter(isFemaleHero, newHeroes);
superhumans  = filter(isSuperhuman, newHeroes);

femaleHeroes = newHeroes.filter(isFemaleHero);
superhumans  = newHeroes.filter(isSuperhuman);

function isBlackWidow(hero) {
    return (hero.name === 'Black Widow');
}

let blackWidow = newHeroes.filter(isBlackWidow)[0];

function findFirst(predicate, arr) {
    for (let item of arr) {
        if (predicate(item)) {
            return item;
        }
    }
}

blackWidow = findFirst(isBlackWidow, newHeroes);


blackWidow = newHeroes.find(isBlackWidow);

