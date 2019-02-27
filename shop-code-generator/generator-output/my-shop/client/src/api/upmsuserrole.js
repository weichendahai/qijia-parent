
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/upmsuserrole/list',
        method: 'get'
    });
}

export function insertUpmsUserRole(data) {
    return fetch({
        url: '/api/upmsuserrole/insert',
        method: 'post',
        data,
    });
}

export function deleteUpmsUserRole(data) {
    return fetch({
        url: '/api/upmsuserrole/delete',
        method: 'post',
        data,
    });
}

export function updateUpmsUserRole(data) {
    return fetch({
        url: '/api/upmsuserrole/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}