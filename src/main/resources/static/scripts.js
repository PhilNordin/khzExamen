        function showNoCarsPopup() {
            alert("No car available");
            setTimeout(function() {
                window.location.href = "/";
            }, 5000);
        }

function openModal(carId) {
    document.getElementById('carId').value = carId;
    document.getElementById('orderModal').style.display = "block";
}

            function closeModal() {
                document.getElementById('orderModal').style.display = "none";
            }

            window.onclick = function(event) {
                if (event.target == document.getElementById('orderModal')) {
                    closeModal();
                }
            }