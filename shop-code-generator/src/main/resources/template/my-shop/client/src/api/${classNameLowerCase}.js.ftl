<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameAllLower = table.classNameLowerCase>

<#include "/java_copyright.include">

import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/${tableNameAllLower}/list',
        method: 'get'
    });
}

export function insert${className}(data) {
    return fetch({
        url: '/api/${tableNameAllLower}/insert',
        method: 'post',
        data,
    });
}

export function delete${className}(data) {
    return fetch({
        url: '/api/${tableNameAllLower}/delete',
        method: 'post',
        data,
    });
}

export function update${className}(data) {
    return fetch({
        url: '/api/${tableNameAllLower}/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}