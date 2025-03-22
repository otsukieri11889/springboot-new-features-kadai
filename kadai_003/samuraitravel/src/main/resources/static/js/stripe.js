const stripe = Stripe('pk_test_51QqRYrCV0nBAHXptcUj5FDKocxmfhqJGcTIpJ7ndTjvCqKCpZYWyTOJoH3nlhKFZ5gv3k1ZtqX8tpI2CGuW1iTaE00ES6a8MnS');
const paymentButton = document.querySelector('#paymentButton');

paymentButton.addEventListener('click', () => {
 stripe.redirectToCheckout({
   sessionId: sessionId
 })
});