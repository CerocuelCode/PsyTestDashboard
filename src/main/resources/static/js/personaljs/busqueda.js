function searchTable(input) {
    // Convierte el valor del `input` a minúsculas para hacer una búsqueda insensible a mayúsculas/minúsculas.
    const filter = input.value.toLowerCase();
    // const rows = document.querySelectorAll('table tbody tr');
    const rows = document.querySelectorAll('table tbody tr');
    // Este indicador se usa para saber si al menos una fila coincide con el filtro de búsqueda.
    let found = false;

    // Iteración sobre las Filas
    // Para cada fila, la función: - Selecciona todas las celdas (`<td>`) dentro de esa fila. - Itera sobre las celdas
    // para verificar si alguna contiene el texto que coincide con el filtro (comparación insensible a
    // minúsculas/mayúsculas mediante el metodo toLowerCase). - Si al menos una celda coincide,
    // la fila se muestra (`row.style.display = ''`), de lo contrario, se oculta (`row.style.display = 'none'`).
    // Actualiza el indicador `found` si encuentra una coincidencia. `
    rows.forEach(function (row) {
        const cells = row.querySelectorAll('td');
        let matches = false;

        cells.forEach(function (cell) {
            if (cell.textContent.toLowerCase().includes(filter)) {
                matches = true;
            }
        });

        if (matches) {
            row.style.display = '';
            found = true;
        } else {
            row.style.display = 'none';
        }
    });

    // Manejo del Mensaje "No Resultados":
    // Si se encontró al menos una fila que coincide, oculta el mensaje de "No Resultados" (`noResults.style.display = 'none'`).
    // Si no se encontró ninguna fila que coincida, muestra el mensaje de "No Resultados" (`noResults.style.display = 'block'`).
    const noResults = document.getElementById('no-results');
    if (found) {
        noResults.style.display = 'none';
    } else {
        noResults.style.display = 'block';
    }
}