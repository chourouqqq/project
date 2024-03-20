document.getElementById("rollDiceBtn").addEventListener("click", function() {
    var diceResult = rollDice();
    document.getElementById("dice").innerText = "Dice: " + diceResult;
});

function rollDice() {
    return Math.floor(Math.random() * 6) + 1;
}
