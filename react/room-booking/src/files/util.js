
const getToday = () => {

    const today = new Date();
    const year = today.getFullYear();
    const month = today.getMonth() + 1;
    const day = today.getDate();
    return ({
        year, month, day
    });
};
const toDateString = (date) => {

    const yearText = `${date.year}`;
    const monthText = date.month<10 ? `0${date.month}` : `${date.month}`;
    const dayText = date.day<10 ? `0${date.day}` : `${date.day}`;

    return `${yearText}-${monthText}-${dayText}`;
};

const indexof = (array, predicate) => {

    return array.reduce((a, c, i) => {

        if(a !== -1)
            return a;
        else if(predicate(c))
            return i;
        else
            return -1;
    }, -1);
}


export {getToday, toDateString, indexof};