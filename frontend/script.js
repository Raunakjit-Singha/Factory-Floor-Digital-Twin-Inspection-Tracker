const BASE_URL = "http://localhost:8088";

function addEquipment() {
    fetch(BASE_URL + "/equipment", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            name: document.getElementById("name").value,
            location: document.getElementById("location").value,
            status: "ACTIVE"
        })
    }).then(res => res.json()).then(data => alert("Equipment added"));
}

function addInspection() {
    fetch(BASE_URL + "/inspection", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
            equipmentId: document.getElementById("equipmentId").value,
            inspector: document.getElementById("inspector").value,
            status: "OK",
            remarks: "Checked"
        })
    }).then(res => res.json()).then(data => alert("Inspection added"));
}

function loadEquipment() {
    fetch(BASE_URL + "/equipment")
    .then(res => res.json())
    .then(data => {
        document.getElementById("equipmentList").innerHTML =
            data.map(e => `<li>${e.name} - ${e.location}</li>`).join("");
    });
}

function loadInspection() {
    fetch(BASE_URL + "/inspection")
    .then(res => res.json())
    .then(data => {
        document.getElementById("inspectionList").innerHTML =
            data.map(i => `<li>Equipment ${i.equipmentId} - ${i.status}</li>`).join("");
    });
}