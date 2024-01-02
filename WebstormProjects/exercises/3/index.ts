/*

Intro:

    Since we already have some of the additional
    information about our users, it's a good idea
    to output it in a nice way.

Exercise:

    Fix type errors in logPerson function.

    logPerson function should accept both User and Admin
    and should output relevant information according to
    the input: occupation for User and role for Admin.

*/

interface User {
    name: string;
    age: number;
    occupation: string;
    type:'user'
}

interface Admin {
    name: string;
    age: number;
    role: string;
    type:'admin'
}

export type Person = User | Admin;

export const persons: Person[] = [
    {
        name: 'Max Mustermann',
        age: 25,
        occupation: 'Chimney sweep',
        type:'user'
    },
    {
        name: 'Jane Doe',
        age: 32,
        role: 'Administrator',
        type:'admin'
    },
    {
        name: 'Kate Müller',
        age: 23,
        occupation: 'Astronaut',
        type:'user'
    },
    {
        name: 'Bruce Willis',
        age: 64,
        role: 'World saver',
        type:'admin'
    }
];

export function logPerson(person: Person) {
    let additionalInformation: string;
    if (person.type == 'admin') {
        additionalInformation = person.role;
    } else {
        additionalInformation = person.occupation;
    }
    console.log(` - ${person.name}, ${person.age}, ${additionalInformation}`);
}

persons.forEach(logPerson);

// In case you are stuck:
// https://www.typescriptlang.org/docs/handbook/2/narrowing.html#the-in-operator-narrowing
