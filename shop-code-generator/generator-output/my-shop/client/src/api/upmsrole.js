
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/upmsrole/list',
        method: 'get'
    });
}

export function insertUpmsRole(data) {
    return fetch({
        url: '/api/upmsrole/insert',
        method: 'post',
        data,
    });
}

export function deleteUpmsRole(data) {
    return fetch({
        url: '/api/upmsrole/delete',
        method: 'post',
        data,
    });
}

export function updateUpmsRole(data) {
    return fetch({
        url: '/api/upmsrole/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}