import React from 'react';

function TableHeader({columns, onSort, sortedColumn}) {
    return (
        <th>
            <tr>
                {columns.map(col =>
                    <td key={col.title} onClick={() => onSort(col.path)}>{col.title}</td>
                )}
            </tr>
        </th>
    );
}

export default TableHeader;
