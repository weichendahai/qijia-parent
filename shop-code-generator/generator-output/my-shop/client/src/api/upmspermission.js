
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/upmspermission/list',
        method: 'get'
    });
}

export function insertUpmsPermission(data) {
    return fetch({
        url: '/api/upmspermission/insert',
        method: 'post',
        data,
    });
}

export function deleteUpmsPermission(data) {
    return fetch({
        url: '/api/upmspermission/delete',
        method: 'post',
        data,
    });
}

export function updateUpmsPermission(data) {
    return fetch({
        url: '/api/upmspermission/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}