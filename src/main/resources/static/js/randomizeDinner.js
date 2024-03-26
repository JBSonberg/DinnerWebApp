function randomizeDinner() {
    fetch('/mysterydinner')
        .then(response => response.json())
        .then(data => {
            const optionsDiv = document.getElementById('dinnerOptions');
            optionsDiv.innerHTML = ''; // Clear previous options

            setTimeout(() => {
                // Display the protein with animation
                const protein = document.createElement('p');
                protein.textContent = `Protein: ${data.protein}`;
                protein.className = 'slide-in';
                optionsDiv.appendChild(protein);
            }, 500); // Delay for protein reveal

            setTimeout(() => {
                // Display the first add-on with animation
                const addOn1 = document.createElement('p');
                addOn1.textContent = `Add-On 1: ${data.addOns[0]}`;
                addOn1.className = 'slide-in';
                optionsDiv.appendChild(addOn1);
            }, 1500); // Additional delay for first add-on reveal

            setTimeout(() => {
                // Display the second add-on with animation
                const addOn2 = document.createElement('p');
                addOn2.textContent = `Add-On 2: ${data.addOns[1]}`;
                addOn2.className = 'slide-in';
                optionsDiv.appendChild(addOn2);
            }, 2500); // Additional delay for second add-on reveal
        })
        .catch(error => console.error('Error:', error));
}
