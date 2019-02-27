
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/upmsuserpermission/list',
        method: 'get'
    });
}

export function insertUpmsUserPermission(data) {
    return fetch({
        url: '/api/upmsuserpermission/insert',
        method: 'post',
        data,
    });
}

export function deleteUpmsUserPermission(data) {
    return fetch({
        url: '/api/upmsuserpermission/delete',
        method: 'post',
        data,
    });
}

export function updateUpmsUserPermission(data) {
    return fetch({
        url: '/api/upmsuserpermission/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}