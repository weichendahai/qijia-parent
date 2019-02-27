
/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */


import fetch from 'utils/fetch';

export function fetchList() {
    return fetch({
        url: '/api/upmsrolepermission/list',
        method: 'get'
    });
}

export function insertUpmsRolePermission(data) {
    return fetch({
        url: '/api/upmsrolepermission/insert',
        method: 'post',
        data,
    });
}

export function deleteUpmsRolePermission(data) {
    return fetch({
        url: '/api/upmsrolepermission/delete',
        method: 'post',
        data,
    });
}

export function updateUpmsRolePermission(data) {
    return fetch({
        url: '/api/upmsrolepermission/update',
        method: 'post',
        data,
        // headers: {
        //   'Content-type': 'application/x-www-form-urlencoded'
        // }
    });
}