document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const formData = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
        role: document.getElementById('role').value,
    };

    fetch('/api/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        if (data.token) {
            // Handle successful login
            console.log('Login successful!', data);
            // Save the token, redirect, etc.
        } else {
            // Handle error
            console.error('Login failed:', data.error);
        }
    })
    .catch(error => console.error('Error:', error));
});
