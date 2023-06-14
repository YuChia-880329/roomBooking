
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

export {getToday, toDateString};